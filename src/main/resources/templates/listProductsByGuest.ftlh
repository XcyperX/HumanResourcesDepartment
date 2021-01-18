<#import "parts/common.ftlh" as c>
<#import "parts/listProducts.ftlh" as lp>

<@c.page>
    <div class="dropdown">
    <button class="btn btn-secondary dropdown-toggle mb-2" type="button" id="dropdownMenuButton" data-toggle="dropdown"
            aria-haspopup="true" aria-expanded="false">
        Мой заказ
    </button>
    <div class="dropdown-menu" style="width: 18rem;">
        <form class="history_products_order px-4 py-3" id="history_products_order">

        </form>
        <div class="dropdown-divider"></div>
        <div class="row justify-content-between">
            <div class="col ml-4">
                <p id="sum_order" class="sum_order">0</p>
            </div>
            <div class="col-5">
                <button type="submit" class="btn btn-primary">Заказать</button>
            </div>
        </div>
    </div>

    <@lp.listPruduct products=listProducts categories=categories/>
</@c.page>