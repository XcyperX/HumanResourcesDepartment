<#import "parts/common.ftlh" as c>
<#import "parts/listEmployees.ftlh" as e>

<@c.page>
    <a class="btn btn-primary mb-2" type="button" href="/pdf/request">Сформировать отчет</a>
    <@e.listEmployees orderHistory="" products=products categories=categories positions=positions positionsNames=positionsNames vacation=true/>
</@c.page>