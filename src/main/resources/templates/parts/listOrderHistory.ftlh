<#import "createProducts.ftlh" as p>
<#import "dataOrder.ftlh" as coc>
<#macro listOrders orderHistories products categories manufacturer>
    <table class="table table-bordered mb-0">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Статус заказа</th>
            <th scope="col">Дата заказа</th>
            <th scope="col">Дата выдачи</th>
            <th scope="col">Цена заказа</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list orderHistories as order>
            <tr>
                <td>${order.id}</td>
                <td>
                    <#if order.status?has_content>
                        <#list statuses?values as status>
                            <#if status == order.status>
                                ${status.getNameStatus()}
                            </#if>
                        </#list>
                    <#else>
                        Null
                    </#if>
                </td>
                <td>${order.dateOrder}</td>
                <td>
                    <#if order.dateReception?has_content>
                        ${order.dateReception}
                    <#else>
                        Null
                    </#if>
                </td>
                <td>${order.price}</td>
                <td>
                    <button type="button" class="btn btn-primary" data-toggle="modal"
                            data-target="#infoOrder_${order.id}">
                        Подробнее
                    </button>
                    <!-- Modal -->
                    <div class="modal fade" id="infoOrder_${order.id}" tabindex="-1" role="dialog"
                         aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <div>
                                        <h5 class="modal-title" id="exampleModalLabel">Заказ №: ${order.id}</h5>
                                    </div>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <@coc.employee employees=order.customer products=order.productList categories=categories manufacturer=manufacturer subdivisions=""/>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </#list>
    </table>
</#macro>

