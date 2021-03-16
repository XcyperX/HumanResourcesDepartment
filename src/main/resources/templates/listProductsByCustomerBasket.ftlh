<#import "parts/common.ftlh" as c>
<#import "parts/listProductsCardByAll.ftlh" as lpc>
<#import "parts/filteredBlock.ftlh" as fb>
<#import "parts/searchBlock.ftlh" as sb>
<#import "parts/createOrderCustomer.ftlh" as coc>

<@c.page>
    <div class="row">
        <div class="col-sm-9">
            <div class="container-fluid">
                <div class="row row-cols-1 row-cols-md-4">
                    <@lpc.listPruduct products=products categories=categories/>
                </div>
            </div>
        </div>
        <div class="col-sm-3 pr-0">
            <div class="container">
                <div class="row mb-2">
                    <div class="col pl-0">
                        <h5 id="priceProductBasket">Сумма заказа: </h5>
                        <button type="button" class="btn btn-primary btn-block" data-toggle="modal"
                                data-target="#createOrder">
                            Оформить заказ
                        </button>
                        <!-- Modal -->
                        <div class="modal fade" id="createOrder" tabindex="-1" role="dialog"
                             aria-labelledby="exampleModalLabel"
                             aria-hidden="true">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Информация по заказу</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <form id="createOrder" name="createOrder">
                                        <div class="modal-body">
                                            <@coc.employee employees=user!"" products=products categories=categories manufacturer=manufacturer subdivisions=subdivisions/>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена
                                            </button>
                                            <button type="button" class="btn btn-primary"
                                                    onclick="submitCrateOrder()">Оформить заказ
                                            </button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row mb-2">
                    <div class="col pl-0">
                        <button type="button" class="btn btn-secondary btn-block" onclick="deleteCookie()">Очистить
                            корзину
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@c.page>