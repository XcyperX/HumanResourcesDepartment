<#import "parts/common.ftlh" as c>
<#import "parts/listProductsCard.ftlh" as lp>
<#import "parts/createProducts.ftlh" as p>

<@c.page>
    <a class="btn btn-primary mb-2" type="button" href="/pdf/request/agreement">Сформировать отчет</a>
    <button type="button" class="btn btn-primary mb-2" data-toggle="modal" data-target="#createProduct">
        Добавить новое блюдо
    </button>
    <!-- Modal -->
    <div class="modal fade" id="createProduct" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Форма создания</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена</button>
                    <button type="button" class="btn btn-primary" onclick="submitCreateProduct()">Создать</button>
                </div>
            </div>
        </div>
    </div>
    <@lp.listPruduct products=listProducts categories=categories/>
</@c.page>