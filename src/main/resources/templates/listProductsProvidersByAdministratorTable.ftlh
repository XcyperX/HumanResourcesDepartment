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
                <div class="row mb-2">
                    <label>Выберите поставщика</label>
                    <select id="categories_id" class="form-control">
                        <option value="all">Все</option>
                        <#list providers as provide>
                            <option value="${provide.id}">${provide.nameFirm}</option>
                        </#list>
                    </select>
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
<#--                    <div class="col-auto pr-0">-->
<#--                        <a class="btn btn-primary" type="button" href="/provider/table/product">Таблица</a>-->
<#--                        <a class="btn btn-primary" type="button" href="/provider/card/product">Карточки</a>-->
<#--                    </div>-->
                </div>
                <div class="row">
                        <@lpt.listProducts products=products categories=categories manufacturer=manufacturer stores=stores user=user change=false/>
                </div>
            </div>
        </div>
    </div>
</@c.page>