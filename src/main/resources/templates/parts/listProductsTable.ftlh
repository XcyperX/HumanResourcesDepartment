<#import "createProducts.ftlh" as p>
<#macro listProducts stores products categories manufacturer user change=true>
    <table class="table table-bordered mb-0">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Название</th>
            <th scope="col">Склад</th>
            <th scope="col">Категория</th>
            <th scope="col">Производитель</th>
            <th scope="col">Количество</th>
            <th scope="col">Цена</th>
            <#if change>
                <th scope="col"></th>
                <th scope="col"></th>
            </#if>
        </tr>
        </thead>
        <tbody>
            <#list products as product>
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>
                        <#list stores as store>
                            <#if store.id == product.storeId>
                                ${store.name}
                            </#if>
                        </#list>
                    </td>
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
                    <#if change>
                        <td>
                            <button type="button" class="btn btn-primary" data-toggle="modal"
                                    data-target="#updateProduct_${product.id}">
                                Изменить
                            </button>

                            <!-- Modal -->
                            <div class="modal fade" id="updateProduct_${product.id}" tabindex="-1" role="dialog"
                                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-lg">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <div>
                                                <h5 class="modal-title" id="exampleModalLabel">Артикул: ${product.id} <br>  Наименование: ${product.name}</h5>
                                            </div>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <@p.pruduct products=product categories=categories manufacturer=manufacturer stores=stores user=user/>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена
                                            </button>
                                            <button type="button" class="btn btn-primary"
                                                    onclick="submitCreateAndUpdateProduct(${product.id})">Сохранить изменения
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </td>
                        <td><input class="btn btn-primary" type="button" onclick="deleteProductById(${product.id})"
                                   value="Удалить"></td>
                    </#if>
                </tr>
            </#list>
    </table>
</#macro>

