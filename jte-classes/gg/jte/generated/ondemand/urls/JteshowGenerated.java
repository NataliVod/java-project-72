package gg.jte.generated.ondemand.urls;
import hexlet.code.dto.urls.UrlPage;
import hexlet.code.util.NamedRoutes;
public final class JteshowGenerated {
	public static final String JTE_NAME = "urls/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,6,6,9,9,12,12,12,18,18,18,22,22,22,26,26,26,65,65,65};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlPage page) {
		jteOutput.writeContent("\r\n\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"container-lg mt-5\">\r\n\r\n    <h1>Сайт ");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getUrl().getName());
				jteOutput.writeContent("</h1>\r\n\r\n    <table class=\"table table-bordered table-hover mt-3\">\r\n        <tbody>\r\n        <tr>\r\n            <td>ID</td>\r\n            <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getId());
				jteOutput.writeContent("</td>\r\n        </tr>\r\n        <tr>\r\n            <td>Имя</td>\r\n            <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getName());
				jteOutput.writeContent("</td>\r\n        </tr>\r\n        <tr>\r\n            <td>Дата создания</td>\r\n            <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(String.valueOf(page.getUrl().getCreatedAt()));
				jteOutput.writeContent("</td>\r\n        </tr>\r\n        </tbody>\r\n    </table>\r\n\r\n    <h2 class=\"mt-5\">Проверки</h2>\r\n    <form method=\"post\" action=\"/\">\r\n        <button type=\"submit\" class=\"btn btn-primary\">Запустить проверку</button>\r\n    </form>\r\n\r\n    <table class=\"table table-bordered table-hover mt-3\">\r\n        <thead>\r\n        <th class=\"col-1\">ID</th>\r\n        <th class=\"col-1\">Код ответа</th>\r\n        <th>title</th>\r\n        <th>h1</th>\r\n        <th>description</th>\r\n        <th class=\"col-2\">Дата проверки</th>\r\n        </thead>\r\n        <tbody>\r\n        <tr>\r\n            <td>2</td>\r\n            <td>200</td>\r\n            <td>Example Domain</td>\r\n            <td>Example Domain</td>\r\n            <td></td>\r\n            <td>02/09/2023 22:08</td>\r\n        </tr>\r\n        <tr>\r\n            <td>1</td>\r\n            <td>200</td>\r\n            <td>Example Domain</td>\r\n            <td>Example Domain</td>\r\n            <td></td>\r\n            <td>02/09/2023 22:07</td>\r\n        </tr>\r\n        </tbody>\r\n    </table>\r\n    </div>\r\n");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlPage page = (UrlPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
