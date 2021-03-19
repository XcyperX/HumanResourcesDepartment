<#import "createProducts.ftlh" as p>
<#import "dataOrder.ftlh" as coc>
<#macro listOrders users stores orderHistories products categories manufacturer deliveries=false>
    <table class="table table-bordered mb-0">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Статус заказа</th>
            <th scope="col">Дата заказа</th>
            <#if deliveries>
                <th scope="col">Дата приема</th>
            <#else>
                <th scope="col">Дата выдачи</th>
            </#if>

            <th scope="col">Цена заказа</th>
            <th scope="col"></th>
            <#if deliveries>
                <th scope="col"></th>
            </#if>
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
                                    <#if deliveries>
                                        <#list users as user>
                                            <#if user.id = order.userId>
                                                <@coc.employee employees=user products=order categories=categories manufacturer=manufacturer subdivisions=""/>
                                            </#if>
                                        </#list>
                                    <#else>
                                        <#list users as user>
                                            <#if order.userId?has_content>
                                                <#if user.id = order.userId>
                                                    <@coc.employee employees=user products=order categories=categories manufacturer=manufacturer subdivisions=""/>
                                                </#if>
                                            </#if>
                                        </#list>
                                        <#if order.customer?has_content>
                                            <@coc.employee employees=order.customer products=order categories=categories manufacturer=manufacturer subdivisions=""/>
                                        </#if>
                                    </#if>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
                <#if deliveries>
                    <td>
                        <button type="button" class="btn btn-primary" data-toggle="modal"
                                data-target="#storeOrder_${order.id}">
                            Принять доставку
                        </button>
                        <div class="modal fade" id="storeOrder_${order.id}" tabindex="-1" role="dialog"
                             aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog modal-sm">
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
                                        <div class="col pr-0 pl-0">
                                            <label>Выберите склад</label>
                                            <select id="store_id" class="form-control">
                                                <#list stores as store>
                                                    <option value="${store.id}">${store.name}</option>
                                                </#list>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </td>
                </#if>
            </tr>
        </#list>
    </table>
</#macro>

