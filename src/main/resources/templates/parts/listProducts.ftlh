<#import "createProducts.ftlh" as p>
<#macro listPruduct products categories administrator=false guest=false>
    <#if products?has_content>
        <div class="row row-cols-1 row-cols-md-3">
            <#list products as product>
                <div class="col mb-4">
                    <div class="form-row">
                        <div class="card" style="width: 22rem;">
                            <div class="card-body">
                                <h5 class="card-title">${product.name}</h5>
                                <p class="card-text">${product.description}</p>
                                <hr>
                                <p class="card-text">${product.structure}</p>
                                <hr>
                                <div class="row justify-content-between">
                                    <div class="col">
                                        ${product.price} р.
                                    </div>
                                    <#if administrator>
                                        <div class="col-8">
                                            <button class="btn btn-primary mr-2" onclick="deleteProductById(${product.id})">Удалить</button>
                                            <button type="button" class="btn btn-primary" data-toggle="modal"
                                                    data-target="#updateProduct_${product.id}">
                                                Изменить
                                            </button>
                                            <!-- Modal -->
                                            <div class="modal fade" id="updateProduct_${product.id}" tabindex="-1"
                                                 role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                <div class="modal-dialog modal-lg">
                                                    <div class="modal-content">
                                                        <form id="createProduct" name="createProduct"
                                                              enctype="multipart/form-data">
                                                            <div class="modal-header">
                                                                <h5 class="modal-title" id="exampleModalLabel">
                                                                    Редатировать ${product.name}</h5>
                                                                <button type="button" class="close" data-dismiss="modal"
                                                                        aria-label="Close">
                                                                    <span aria-hidden="true">&times;</span>
                                                                </button>
                                                            </div>
                                                            <div class="modal-body">
                                                                <@p.pruduct categories=categories productsUpdate=product administrator=true/>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button type="button" class="btn btn-secondary"
                                                                        data-dismiss="modal">Отмена
                                                                </button>
                                                                <button type="button" class="btn btn-primary"
                                                                        onclick="submitCreateAndUpdateProduct(${product.id})">
                                                                    Изменить
                                                                </button>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    <#else>
                                        <div class="col-5">
                                            <button class="btn btn-primary" onclick="addOrder(${product.id})">Заказать</button>
                                        </div>
                                    </#if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </#if>
</#macro>