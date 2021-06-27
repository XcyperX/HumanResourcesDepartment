<#macro listSubdivision subdivisions>
    <form id="createSubdivision" name="createSubdivision">
        <div class="form-row mb-3">
            <div class="col-8">
                <input id="subdivision_input" type="text" name="subdivision_input" class="form-control"
                       placeholder="Введите название подразделения">
            </div>
            <div class="col">
                <input class="btn btn-primary btn-block" type="button" onclick="submitNewSubdivision()"
                       value="Добавить подразделение">
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
            <#list subdivisions as subdivision>
                <tr>
                    <td>${subdivision.id}</td>
                    <td>${subdivision.name}</td>
                </tr>
            </#list>
    </table>
</#macro>

