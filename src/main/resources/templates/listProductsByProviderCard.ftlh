<#import "parts/common.ftlh" as c>
<#import "parts/listProductsCard.ftlh" as lpc>
<#import "parts/listProductsTable.ftlh" as lpt>
<#import "parts/createProducts.ftlh" as p>
<#import "parts/listStore.ftlh" as store>
<#import "parts/listManufaturer.ftlh" as man>

<@c.page>
    <div class="row">
        <div class="col-sm-2">
            <div class="container">
                <div class="row mb-2">
                    <p class="text-justify">Количество товаров: ${countAllProduct}</p>
                </div>
                <div class="row">
                    <button type="button" class="btn btn-primary btn-block mb-2" data-toggle="modal" data-target="#createProduct">
                        Добавить продукт
                    </button>
                    <!-- Modal -->
                    <div class="modal fade" id="createProduct" tabindex="-1" role="dialog"
                         aria-labelledby="exampleModalLabel"
                         aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Добавить продукт</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <form id="createProduct" name="createProduct" enctype="multipart/form-data">
                                    <div class="modal-body">
                                        <@p.pruduct products="" categories=categories manufacturer=manufacturer stores=stores user=user/>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена
                                        </button>
                                        <button type="button" class="btn btn-primary"
                                                onclick="submitCreateAndUpdateProduct()">Добавить
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <button type="button" class="btn btn-primary btn-block mb-2" data-toggle="modal" data-target="#createStore">
                        Список складов
                    </button>
                    <!-- Modal -->
                    <div class="modal fade" id="createStore" tabindex="-1" role="dialog"
                         aria-labelledby="exampleModalLabel"
                         aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Список складов</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <@store.listStore stores=stores user=user/>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <button type="button" class="btn btn-primary btn-block mb-2" data-toggle="modal"
                            data-target="#createManufacturer">
                        Список производителей
                    </button>
                    <!-- Modal -->
                    <div class="modal fade" id="createManufacturer" tabindex="-1" role="dialog"
                         aria-labelledby="exampleModalLabel"
                         aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Список производителей</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <@man.listManufacturer manufacturer=manufacturer/>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row mb-2">
                    <label>Выберите категорию</label>
                    <select id="categories_id" class="form-control">
                        <option value="all">Все</option>
                        <#list categories as categori>
                            <option value="${categori.id}">${categori.name}</option>
                        </#list>
                    </select>
                </div>
                <div class="row mb-2">
                    <label>Выберите производителя</label>
                    <select id="manufacturer_id" class="form-control">
                        <option value="all">Все</option>
                        <#list manufacturer as manufacter>
                            <option value="${manufacter.id}">${manufacter.name}</option>
                        </#list>
                    </select>
                </div>
                <div class="row mb-2">
                    <label>Выберите склад</label>
                    <select id="store_id" class="form-control">
                        <option value="all">Все</option>
                        <#list stores as store>
                            <option value="${store.id}">${store.name}</option>
                        </#list>
                    </select>
                </div>
            </div>
        </div>
        <div class="col-sm-10">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col pl-0">
                        <input id="searchProduct" type="text" name="searchProduct" class="form-control">
                    </div>
                    <div class="col-auto pr-0">
                        <button type="button" class="btn btn-light">Найти</button>
                    </div>
                </div>
                <div class="row mb-2">
                    <div class="col pl-0">
                        <span>Сортировать: </span>
                        <button type="button" class="btn btn-light btn-sm">По цене</button>
                        <button type="button" class="btn btn-light btn-sm">По колчеству заказов</button>
                        <button type="button" class="btn btn-light btn-sm">По новизне</button>
                    </div>
                    <div class="col-auto pr-0">
                        <a class="btn btn-primary" type="button" href="/provider/table/product">Таблица</a>
                        <a class="btn btn-primary" type="button" href="/provider/card/product">Карточки</a>
                    </div>
                </div>
                <div class="row">
                    <div class="row row-cols-1 row-cols-md-2">
                        <@lpc.listPruduct products=products categories=categories/>
                    </div>
                </div>
            </div>
        </div>
    </div>
<#--<div class="row">-->
<#--<div class="col">-->
<#--<button type="button" class="btn btn-primary mb-2" data-toggle="modal" data-target="#createProduct">-->
<#--Добавить продукт-->
<#--</button>-->
<#--<!-- Modal &ndash;&gt;-->
<#--<div class="modal fade" id="createProduct" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"-->
<#--aria-hidden="true">-->
<#--<div class="modal-dialog modal-lg">-->
<#--<div class="modal-content">-->
<#--<div class="modal-header">-->
<#--<h5 class="modal-title" id="exampleModalLabel">Добавить продукт</h5>-->
<#--<button type="button" class="close" data-dismiss="modal" aria-label="Close">-->
<#--<span aria-hidden="true">&times;</span>-->
<#--</button>-->
<#--</div>-->
<#--<form id="createProduct" name="createProduct" enctype="multipart/form-data">-->
<#--<div class="modal-body">-->
<#--<@p.pruduct products="" categories=categories manufacturer=manufacturer stores=stores user=user/>-->
<#--</div>-->
<#--<div class="modal-footer">-->
<#--<button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена</button>-->
<#--<button type="button" class="btn btn-primary"-->
<#--onclick="submitCreateAndUpdateProduct()">Добавить-->
<#--</button>-->
<#--</div>-->
<#--</form>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
<#--<button type="button" class="btn btn-primary mb-2" data-toggle="modal" data-target="#createStore">-->
<#--Список складов-->
<#--</button>-->
<#--<!-- Modal &ndash;&gt;-->
<#--<div class="modal fade" id="createStore" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"-->
<#--aria-hidden="true">-->
<#--<div class="modal-dialog modal-lg">-->
<#--<div class="modal-content">-->
<#--<div class="modal-header">-->
<#--<h5 class="modal-title" id="exampleModalLabel">Список складов</h5>-->
<#--<button type="button" class="close" data-dismiss="modal" aria-label="Close">-->
<#--<span aria-hidden="true">&times;</span>-->
<#--</button>-->
<#--</div>-->
<#--<div class="modal-body">-->
<#--<@store.listStore stores=stores user=user/>-->
<#--</div>-->
<#--<div class="modal-footer">-->
<#--<button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена</button>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
<#--<button type="button" class="btn btn-primary mb-2" data-toggle="modal" data-target="#createManufacturer">-->
<#--Список производителей-->
<#--</button>-->
<#--<!-- Modal &ndash;&gt;-->
<#--<div class="modal fade" id="createManufacturer" tabindex="-1" role="dialog"-->
<#--aria-labelledby="exampleModalLabel"-->
<#--aria-hidden="true">-->
<#--<div class="modal-dialog modal-lg">-->
<#--<div class="modal-content">-->
<#--<div class="modal-header">-->
<#--<h5 class="modal-title" id="exampleModalLabel">Список производителей</h5>-->
<#--<button type="button" class="close" data-dismiss="modal" aria-label="Close">-->
<#--<span aria-hidden="true">&times;</span>-->
<#--</button>-->
<#--</div>-->
<#--<div class="modal-body">-->
<#--<@man.listManufacturer manufacturer=manufacturer/>-->
<#--</div>-->
<#--<div class="modal-footer">-->
<#--<button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена</button>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
<#--<div class="col-auto">-->
<#--<a class="btn btn-primary mb-2" type="button" href="/provider/table/product">Таблица</a>-->
<#--<a class="btn btn-primary mb-2" type="button" href="/provider/card/product">Карточки</a>-->
<#--</div>-->
<#--</div>-->
<#--<div class="row mb-2">-->
<#--<div class="col">-->
<#--<label>Выберите категорию</label>-->
<#--<select id="categories_id" class="form-control">-->
<#--<option value="all">Все</option>-->
<#--<#list categories as categori>-->
<#--<option value="${categori.id}">${categori.name}</option>-->
<#--</#list>-->
<#--</select>-->
<#--</div>-->
<#--<div class="col">-->
<#--<label>Выберите производителя</label>-->
<#--<select id="manufacturer_id" class="form-control">-->
<#--<option value="all">Все</option>-->
<#--<#list manufacturer as manufacter>-->
<#--<option value="${manufacter.id}">${manufacter.name}</option>-->
<#--</#list>-->
<#--</select>-->
<#--</div>-->
<#--<div class="col">-->
<#--<label>Выберите склад</label>-->
<#--<select id="store_id" class="form-control">-->
<#--<option value="all">Все</option>-->
<#--<#list stores as store>-->
<#--<option value="${store.id}">${store.name}</option>-->
<#--</#list>-->
<#--</select>-->
<#--</div>-->
<#--</div>-->
<#--<div class="row row-cols-1 row-cols-md-2">-->
<#--<@lpc.listPruduct products=products categories=categories/>-->
<#--</div>-->
</@c.page>