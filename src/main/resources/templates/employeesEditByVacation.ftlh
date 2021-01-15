<#import "parts/common.ftlh" as c>
<#import "parts/createEmployee.ftlh" as e>

<@c.page>
    <@e.product products=products categories=categories positionsNames=positionsNames vacation=true/>
</@c.page>