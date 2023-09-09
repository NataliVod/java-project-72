package hexlet.code.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hexlet.code.dto.urls.UrlPage;
import hexlet.code.dto.urls.UrlsPage;
import hexlet.code.model.Url;
import hexlet.code.repository.UrlRepository;
import hexlet.code.util.NamedRoutes;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import java.net.URL;

public  class UrlController {
    public static void addUrl(Context ctx) throws SQLException {
        URL parsedUrl;
        try {
            var inputUrl = ctx.formParamAsClass("url", String.class)
                    .check(value -> !value.isEmpty(), "Заполните это поле")
                    .get();

            parsedUrl = new URL(inputUrl);
            var normalizedUrl = parsedUrl.getProtocol() + "://" + parsedUrl.getHost();
            Url url = new Url(normalizedUrl);

            if (UrlRepository.existsByName(url.getName())) {
                ctx.sessionAttribute("flash", "Страница уже существует");
                ctx.sessionAttribute("flash-type", "info");
                ctx.redirect(NamedRoutes.urlsPath());
            }

            UrlRepository.save(url);
            ctx.sessionAttribute("flash", "Страница успешно добавлена");
            ctx.sessionAttribute("flash-type", "success");

            ctx.redirect(NamedRoutes.urlsPath());

        } catch (Exception e) {
            ctx.sessionAttribute("flash", "Некорректный URL");
            ctx.sessionAttribute("flash-type", "danger");
            ctx.redirect(NamedRoutes.rootPath());
        }
    }

    public static void showUrls(Context ctx) throws SQLException {
        var urls = UrlRepository.getEntities();
        var pageNumber = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var per = 10;
        var firstPost = (pageNumber - 1) * per  ;
        List<Url> pagedUrls;

        try {
            pagedUrls = urls.subList(firstPost, firstPost + per);
        } catch (IndexOutOfBoundsException e) {
            pagedUrls = new ArrayList<>();
        }

        var page = new UrlsPage(pagedUrls,pageNumber);
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        page.setFlashType(ctx.consumeSessionAttribute("flash-type"));
        ctx.render("urls/index.jte", Collections.singletonMap("page", page));
    }

    public static void showUrl(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var url = UrlRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Url not found"));

        var page = new UrlPage(url);
        ctx.render("urls/show.jte", Collections.singletonMap("page", page));
    }

}
