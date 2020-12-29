<#import "parts/common.ftlh" as c>
<#import "parts/listRequest.ftlh" as r>

<@c.page>
    <a class="btn btn-primary mb-2" type="button" href="/pdf/request/profit">Сформировать отчет по прибыли</a>
    <@r.listRequest requests=requests admin=true/>
</@c.page>