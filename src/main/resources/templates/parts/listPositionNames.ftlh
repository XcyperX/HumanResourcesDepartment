<#macro listPositionNames positionNames>
    <form id="createManufacturer" name="createManufacturer">
        <div class="form-row mb-3">
            <div class="col-8">
                <input id="position_input" type="text" name="position_input" class="form-control"
                       placeholder="Введите название должности">
            </div>
            <div class="col">
                <input class="btn btn-primary btn-block" type="button" onclick="submitNewPosition()"
                       value="Добавить должность">
            </div>
        </div>
    </form>
    <table class="table table-bordered mb-0">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Название</th>
        </tr>
        </thead>
        <tbody>
            <#list positionNames as positionName>
                <tr>
                    <td>${positionName.id}</td>
                    <td>${positionName.name}</td>
                </tr>
            </#list>
    </table>
</#macro>

