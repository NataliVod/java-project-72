@import hexlet.code.dto.urls.UrlsPage
@import hexlet.code.util.NamedRoutes

@param UrlsPage page


@template.layout.page(
page = page,
content = @`
    <div class="container-lg mt-5">

    <h1>Сайты</h1>

    <table class="table table-bordered table-hover mt-3">

        <thead>
        <tr>
            <th class="col-1">ID</th>
            <th>Имя</th>
            <th class="col-2">Последняя проверка</th>
            <th class="col-1">Код ответа</th>
        </tr>
        </thead>
        <tbody>
        @for(var url : page.getUrls())
            <tr>
                <td>
                    ${url.getId()}
                </td>
                <td>
                    <a href="${NamedRoutes.urlPath(url.getId())}">${url.getName()}</a>
                </td>
                <td>
                    <a> тут будет проверка </a>
                </td>
                <td>
                    <a> тут будет код </a>
                </td>
            </tr>
        @endfor

        </tbody>
    </table>

    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href="?page=${page.getPageNumber() < 2 ? 1 : page.getPageNumber() - 1}"
                   aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li class="page-item"><a class="page-link"
                                     href="${NamedRoutes.urlsPath()}?page=${page.getPageNumber()}">${page.getPageNumber()}</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="?page=${page.getPageNumber() + 1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
    </div>
`
)