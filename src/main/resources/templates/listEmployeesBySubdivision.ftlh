<#import "parts/common.ftlh" as c>
<#import "parts/listEmployees.ftlh" as e>

<@c.page>
    <a class="btn btn-primary mb-2" type="button" href="/pdf/request">Сформировать отчет</a>
    <button class="btn btn-primary mb-2" type="button" data-toggle="collapse" data-target="#addSubdivision"
            aria-expanded="false" aria-controls="collapseExample">
        Создать подразделение
    </button>
    <div class="collapse mb-2" id="addSubdivision">
        <div class="card card-body">
            <div class="container">
                <form id="createSubdivisions" name="createSubdivisions">
                    <div class="form-row mb-3">
                        <label>Название подразделения</label>
                        <input id="subdivision" type="text" name="subdivision" class="form-control"
                               placeholder="Введите название подразделения">
                    </div>
                    <div class="form-row">
                        <input class="btn btn-primary  mb-4" type="button" onclick="submitNewSubdivision()"
                               value="Добавить подразделение">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <@e.listEmployees employees=employees subdivisions=subdivisions positions=positions positionsNames=positionsNames subdivision=true/>
</@c.page>