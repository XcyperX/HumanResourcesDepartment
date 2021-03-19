<#macro listStores stores>
    <div class="col pr-0 mr-0">
        <label>Выберите склад</label>
        <select id="store_id" class="form-control">
            <#list stores as store>
                <option value="${store.id}">${store.name}</option>
            </#list>
        </select>
    </div>
</#macro>