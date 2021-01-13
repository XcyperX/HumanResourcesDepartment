<#import "parts/common.ftlh" as c>
<#import "parts/listEmployees.ftlh" as e>
<#import "parts/createEmployee.ftlh" as ce>

<@c.page>
    <a class="btn btn-primary mb-2" type="button" href="/pdf/request">Сформировать отчет</a>
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
                    <button type="button" class="btn btn-primary" onclick="submitCrateAndUpdateEmployees()">Добавить сотрудника</button>
                </div>
            </div>
        </div>
    </div>

    <button type="button" class="btn btn-primary mb-2" data-toggle="modal" data-target="#createPosition">
        Список должностей
    </button>
    <!-- Modal -->
    <div class="modal fade" id="createPosition" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Список должностей</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <@e.listEmployees agreementData="" employees=employees subdivisions=subdivisions positions=positions positionsNames=positionsNames position=true/>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                </div>
            </div>
        </div>
    </div>

    <button type="button" class="btn btn-primary mb-2" data-toggle="modal" data-target="#createSubdivision">
        Список подразделений
    </button>
    <!-- Modal -->
    <div class="modal fade" id="createSubdivision" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Список подразделений</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <@e.listEmployees agreementData="" employees=employees subdivisions=subdivisions positions=positions positionsNames=positionsNames subdivision=true/>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                </div>
            </div>
        </div>
    </div>

    <@e.listEmployees agreementData="" employees=employees subdivisions=subdivisions positions=positions positionsNames=positionsNames all=true/>
</@c.page>