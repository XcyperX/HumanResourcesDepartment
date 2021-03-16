<#import "createProducts.ftlh" as p>
<#macro listProducts products categories manufacturer>
    <table class="table table-bordered mb-0">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Название</th>
            <th scope="col">Категория</th>
            <th scope="col">Производитель</th>
            <th scope="col">Цена</th>
        </tr>
        </thead>
        <tbody>
            <#list products as product>
                <tr>
                    <td class="product_id_order">${product.id}</td>
                    <td>${product.name}</td>
                    <td>
                        <#list categories as catigori>
                            <#if catigori.id == product.categoriesId>
                                ${catigori.name}
                            </#if>
                        </#list>
                    </td>
                    <td>
                        <#list manufacturer as manufactur>
                            <#if manufactur.id == product.manufacturerId>
                                ${manufactur.name}
                            </#if>
                        </#list>
                    </td>
                    <td>${product.price}</td>
                </tr>
            </#list>
    </table>
</#macro>

