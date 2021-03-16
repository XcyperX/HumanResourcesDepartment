<#--<#macro filteredBlock categories manufacturer stores providers customer=true admin=false >-->
<#macro filteredBlock categories manufacturer stores providers>
    <#if providers?has_content>
        <div class="row mb-2">
            <label>Выберите поставщика</label>
            <select id="filter_provider_id" class="form-control">
                <option value="0">Все</option>
                <#list providers as provide>
                    <option value="${provide.id}">${provide.nameFirm}</option>
                </#list>
            </select>
        </div>
    </#if>
    <div class="row mb-2">
        <label>Выберите категорию</label>
        <select id="filter_categories_id" class="form-control">
            <option value="0" selected>Все</option>
            <#list categories as categori>
                <option value="${categori.id}">${categori.name}</option>
            </#list>
        </select>
    </div>
    <div class="row mb-2">
        <label>Выберите производителя</label>
        <select id="filter_manufacturer_id" class="form-control">
            <option value="0" selected>Все</option>
            <#list manufacturer as manufacter>
                <option value="${manufacter.id}">${manufacter.name}</option>
            </#list>
        </select>
    </div>
    <#if stores?has_content>
        <div class="row mb-2">
            <label>Выберите склад</label>
            <select id="filter_store_id" class="form-control">
                <option value="0" selected>Все</option>
                <#list stores as store>
                    <option value="${store.id}">${store.name}</option>
                </#list>
            </select>
        </div>
    </#if>
</#macro>

