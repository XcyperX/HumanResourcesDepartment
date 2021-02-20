<#macro listManufacturer manufacturer>
    <form id="createManufacturer" name="createManufacturer">
        <div class="form-row mb-3">
            <div class="col-8">
                <input id="manufacturer_input" type="text" name="manufacturer_input" class="form-control"
                       placeholder="Введите название производителя">
            </div>
            <div class="col">
                <input class="btn btn-primary btn-block" type="button" onclick="submitNewManufacturer()"
                       value="Добавить производителя">
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
            <#list manufacturer as manufactur>
                <tr>
                    <td>${manufactur.id}</td>
                    <td>${manufactur.name}</td>
                </tr>
            </#list>
    </table>
</#macro>

