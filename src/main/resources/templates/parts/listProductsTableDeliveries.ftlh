<#import "createProducts.ftlh" as p>
<#macro listProducts providers products categories manufacturer>
    <table class="table table-bordered mb-0">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Поставщик</th>
            <th scope="col">Название</th>
            <th scope="col">Категория</th>
            <th scope="col">Производитель</th>
            <th scope="col">На складе</th>
            <th scope="col">Цена</th>
            <th scope="col">Количество для заказа</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list products as product>
            <tr>
                <td>${product.id}</td>
                <td>
                    <#list providers as provider>
                        <#if provider.id == product.userId>
                            ${provider.nameFirm}
                        </#if>
                    </#list>
                </td>
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
                <td>${product.amount}</td>
                <td>${product.price}</td>
                <td>
                    <input id="amount_product_${product.id}" type="text" name="first_name" class="form-control"
                           placeholder="Введите необходимое количество">
                </td>
                <td>
                    <button type="button" class="btn btn-primary" onclick="addProductInDeliveries(${product.userId}, ${product.id})">
                        Добавить в заказ
                    </button>
                </td>
            </tr>
        </#list>
    </table>
</#macro>

