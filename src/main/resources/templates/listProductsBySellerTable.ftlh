<#import "parts/common.ftlh" as c>
<#import "parts/listProductsCard.ftlh" as lpc>
<#import "parts/listProductsTable.ftlh" as lpt>
<#import "parts/createProducts.ftlh" as p>
<#import "parts/listStore.ftlh" as store>
<#import "parts/listManufaturer.ftlh" as man>
<#import "parts/listCategories.ftlh" as listCat>
<#import "parts/filteredBlock.ftlh" as fb>
<#import "parts/searchBlock.ftlh" as sb>

<@c.page>
    <div class="row">
        <div class="col-sm-2">
            <div class="container">
                 <@fb.filteredBlock categories=categories manufacturer=manufacturer stores=stores providers=""/>
            </div>
        </div>
        <div class="col-sm-10">
            <div class="container-fluid">
                <@sb.searchBlock />
                <div class="row mb-2">
                    <div class="col pl-0">
                        <span>Сортировать: </span>
                        <button type="button" class="btn btn-light btn-sm">По цене</button>
                        <button type="button" class="btn btn-light btn-sm">По колчеству заказов</button>
                        <button type="button" class="btn btn-light btn-sm">По новизне</button>
                    </div>
                </div>
                <div class="row">
                        <@lpt.listProducts products=products categories=categories manufacturer=manufacturer stores=stores user=user/>
                </div>
            </div>
        </div>
    </div>
</@c.page>