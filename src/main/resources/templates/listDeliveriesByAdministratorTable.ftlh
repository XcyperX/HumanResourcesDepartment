<#import "parts/common.ftlh" as c>
<#import "parts/listEmployees.ftlh" as le>
<#import "parts/listSubdivision.ftlh" as sb>
<#import "parts/listPositionNames.ftlh" as pn>
<#import "parts/createProducts.ftlh" as p>
<#import "parts/listStore.ftlh" as store>
<#import "parts/listManufaturer.ftlh" as man>
<#import "parts/createEmployee.ftlh" as ce>

<@c.page>
    <input id="user_id" type="text" name="user_id" value="${user.id}" hidden>
    <div id="list_deliveries" class="container list_deliveries">

    </div>
</@c.page>