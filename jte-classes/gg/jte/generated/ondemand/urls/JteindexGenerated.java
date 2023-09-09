package gg.jte.generated.ondemand.urls;
import hexlet.code.dto.urls.UrlsPage;
import hexlet.code.util.NamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "urls/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,6,6,9,9,24,24,27,27,27,30,30,30,30,30,30,30,33,33,33,36,36,36,39,39,46,46,46,46,52,52,52,52,52,52,52,52,52,52,52,55,55,55,55,62,62,62};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlsPage page) {
		jteOutput.writeContent("\r\n\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"container-lg mt-5\">\r\n\r\n    <h1>Сайты</h1>\r\n\r\n    <table class=\"table table-bordered table-hover mt-3\">\r\n        <thead>\r\n        <tr>\r\n            <th class=\"col-1\">ID</th>\r\n            <th>Имя</th>\r\n            <th class=\"col-2\">Последняя проверка</th>\r\n            <th class=\"col-1\">Код ответа</th>\r\n        </tr>\r\n        </thead>\r\n        <tbody>\r\n        ");
				for (var url : page.getUrls()) {
					jteOutput.writeContent("\r\n            <tr>\r\n                <td>\r\n                    ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(url.getId());
					jteOutput.writeContent("\r\n                </td>\r\n                <td>\r\n                    <a href=\"/urls/");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(url.getId());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\">");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(url.getName());
					jteOutput.writeContent("</a>\r\n                </td>\r\n                <td>\r\n                     ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(url.getName());
					jteOutput.writeContent("\r\n                </td>\r\n                <td>\r\n                     ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(url.getName());
					jteOutput.writeContent("\r\n                </td>\r\n            </tr>\r\n        ");
				}
				jteOutput.writeContent("\r\n        </tbody>\r\n    </table>\r\n\r\n    <nav aria-label=\"Page navigation\">\r\n        <ul class=\"pagination justify-content-center mt-5\">\r\n            <li class=\"page-item\">\r\n                <a class=\"page-link\" href=\"?page=");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(page.getPageNumber() < 2 ? 1 : page.getPageNumber() - 1);
				jteOutput.setContext("a", null);
				jteOutput.writeContent("\"\r\n                   aria-label=\"Previous\">\r\n                    <span aria-hidden=\"true\">&laquo;</span>\r\n                </a>\r\n            </li>\r\n            <li class=\"page-item\"><a class=\"page-link\"\r\n                                     href=\"");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(NamedRoutes.urlsPath());
				jteOutput.setContext("a", null);
				jteOutput.writeContent("?page=");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(page.getPageNumber());
				jteOutput.setContext("a", null);
				jteOutput.writeContent("\">");
				jteOutput.setContext("a", null);
				jteOutput.writeUserContent(page.getPageNumber());
				jteOutput.writeContent("</a>\r\n            </li>\r\n            <li class=\"page-item\">\r\n                <a class=\"page-link\" href=\"?page=");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(page.getPageNumber() + 1);
				jteOutput.setContext("a", null);
				jteOutput.writeContent("\" aria-label=\"Next\">\r\n                    <span aria-hidden=\"true\">&raquo;</span>\r\n                </a>\r\n            </li>\r\n        </ul>\r\n    </nav>\r\n    </div>\r\n");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlsPage page = (UrlsPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
