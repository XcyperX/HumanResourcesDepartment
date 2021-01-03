<#import "parts/common.ftlh" as c>
<#import "parts/listEmployees.ftlh" as e>
<#import "parts/createEmployee.ftlh" as ce>

<@c.page>
    <a class="btn btn-primary mb-2" type="button" href="/pdf/request">Сформировать отчет</a>
    <button class="btn btn-primary mb-2" type="button" data-toggle="collapse" data-target="#addSubdivision"
            aria-expanded="false" aria-controls="collapseExample">
        Добавить сотрудника
    </button>
    <div class="collapse mb-2" id="addSubdivision">
        <div class="card card-body">
            <@ce.employee employees="" subdivisions=subdivisions positionsNames=positionsNames create=true/>
        </div>
    </div>
    <@e.listEmployees employees=employees subdivisions=subdivisions positions=positions positionsNames=positionsNames all=true/>
</@c.page>