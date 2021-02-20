<#macro listStore stores user>
    <form id="createStore" name="createStore">
        <div class="form-row mb-3">
            <div class="col-9">
                <input id="name_store" type="text" name="name_store" class="form-control"
                       placeholder="Введите название склада">
            </div>
            <div class="col">
                <input id="user_id" type="text" name="user_id" class="form-control"
                       value="<#if user?has_content>${user.id}</#if>" hidden>
                <input class="btn btn-primary btn-block" type="button" onclick="submitCreateAndUpdateStore()"
                       value="Добавить склад">
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
            <#list stores as store>
                <tr>
                    <td>${store.id}</td>
                    <td>${store.name}</td>
                </tr>
            </#list>
    </table>
</#macro>

