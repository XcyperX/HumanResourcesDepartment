<#import "parts/common.ftlh" as c>
<#import "parts/listEmployees.ftlh" as e>

<@c.page>
    <a class="btn btn-primary mb-2" type="button" href="/pdf/request">Сформировать отчет</a>
    <button class="btn btn-primary mb-2" type="button" data-toggle="collapse" data-target="#addSubdivision"
            aria-expanded="false" aria-controls="collapseExample">
        Создать должность
    </button>
    <div class="collapse mb-2" id="addSubdivision">
        <div class="card card-body">
            <div class="container">
                <form id="createPosition" name="createPosition">
                    <div class="form-row mb-3">
                        <label>Название должности</label>
                        <input id="position" type="text" name="position" class="form-control"
                               placeholder="Введите название должности">
                    </div>
                    <div class="form-row">
                        <input class="btn btn-primary  mb-4" type="button" onclick="submitNewPosition()"
                               value="Добавить должность">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <@e.listEmployees employees=employees subdivisions=subdivisions positions=positions positionsNames=positionsNames position=true/>
</@c.page>