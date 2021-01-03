<#import "parts/common.ftlh" as c>
<#import "parts/createEmployee.ftlh" as e>

<@c.page>
    <@e.employee employees=employees subdivisions=subdivisions positionsNames=positionsNames vacation=true/>
</@c.page>