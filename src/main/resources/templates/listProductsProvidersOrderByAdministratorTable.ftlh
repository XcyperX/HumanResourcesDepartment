<#import "parts/common.ftlh" as c>
<#import "parts/listOrderHistory.ftlh" as loh>


<@c.page>
    <div class="container-fluid">
<#--        <@sb.searchBlock />-->
        <div class="row">
            <@loh.listOrders users=users stores=stores orderHistories=orderHistories manufacturer=manufacturer categories=categories products=products deliveries=true/>
        </div>
    </div>
</@c.page>