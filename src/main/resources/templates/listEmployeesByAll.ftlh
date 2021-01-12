<#import "parts/common.ftlh" as c>
<#import "parts/listEmployees.ftlh" as e>
<#import "parts/createEmployee.ftlh" as ce>

<@c.page>
    <a class="btn btn-primary mb-2" type="button" href="/pdf/request">Сформировать отчет</a>
    <#--<button class="btn btn-primary mb-2" type="button" data-toggle="collapse" data-target="#addSubdivision"-->
            <#--aria-expanded="false" aria-controls="collapseExample">-->
        <#--Добавить сотрудника-->
    <#--</button>-->

    <button type="button" class="btn btn-primary mb-2" data-toggle="modal" data-target="#createEmployee">
        Добавить сотрудника
    </button>

    <!-- Modal -->
    <div class="modal fade" id="createEmployee" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Форма добавления сотрудника</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <@ce.employee employees="" subdivisions=subdivisions positionsNames=positionsNames create=true/>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена</button>
                    <button type="button" class="btn btn-primary" onclick="submitNewEmployees()">Добавить сотрудника</button>
                </div>
            </div>
        </div>
    </div>

    <#--<div class="collapse mb-2" id="addSubdivision">-->
        <#--<div class="card card-body">-->
            <#--<@ce.employee employees="" subdivisions=subdivisions positionsNames=positionsNames create=true/>-->
        <#--</div>-->
    <#--</div>-->
    <@e.listEmployees employees=employees subdivisions=subdivisions positions=positions positionsNames=positionsNames all=true/>
</@c.page>