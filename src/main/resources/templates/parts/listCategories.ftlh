<#macro listCategories categories>
    <form id="createCategories" name="createCategories">
        <div class="form-row mb-3">
            <div class="col-8">
                <input id="categories_input" type="text" name="categories_input" class="form-control"
                       placeholder="Введите название категории">
            </div>
            <div class="col">
                <input class="btn btn-primary btn-block" type="button" onclick="submitNewCategories()"
                       value="Добавить категорию">
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
            <#list categories as categori>
                <tr>
                    <td>${categori.id}</td>
                    <td>${categori.name}</td>
                </tr>
            </#list>
    </table>
</#macro>

