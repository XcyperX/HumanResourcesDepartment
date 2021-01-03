<#import "parts/common.ftlh" as c>
<#import "parts/listEmployees.ftlh" as e>

<@c.page>
    <a class="btn btn-primary mb-2" type="button" href="/pdf/request">Сформировать отчет</a>
<#--    <div>-->
<#--        <select id="positions" class="form-control mb-3">-->
<#--            <option value="0">Все сотрудники</option>-->
<#--            <option value="1">В отпуске</option>-->
<#--            <option value="2">На работе</option>-->
<#--        </select>-->
<#--    </div>-->
    <@e.listEmployees employees=employees subdivisions=subdivisions positions=positions positionsNames=positionsNames vacation=true/>
</@c.page>