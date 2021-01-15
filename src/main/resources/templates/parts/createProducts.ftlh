<#macro pruduct productsUpdate categories administrator=false guest=false>
    <form method="post" action="/api/test/file" id="createProduct" name="createProduct" enctype="multipart/form-data">
        <div class="form-row mb-2">
            <label>Введите название</label>
            <input id="name" type="text" name="name" class="form-control" placeholder="Введите название "
                   value="<#if productsUpdate?has_content>${productsUpdate.name}</#if>">
        </div>
        <div class="form-row mb-2">
            <label>Введите описание</label>
            <textarea id="description" name="description" class="form-control" placeholder="Введите краткое описание ">
                <#if productsUpdate?has_content>${productsUpdate.description}</#if></textarea>
        </div>
        <div class="form-row mb-2">
            <label>Введите состав</label>
            <textarea id="structure"  name="structure" class="form-control" placeholder="Введите состав ">
                <#if productsUpdate?has_content>${productsUpdate.structure}</#if></textarea>
        </div>
        <div class="form-row mb-2">
            <label>Выберите категорию</label>
            <select id="categories_id" class="form-control">
                <option value="null"></option>
                <#list categories as categori>
                    <#if productsUpdate?has_content>
                        <#if categori.id == productsUpdate.categoriesId>
                            <option value="${categori.id}" selected>${categori.name}</option>
                        <#else>
                            <option value="${categori.id}">${categori.name}</option>
                        </#if>
                    <#else>
                        <option value="${categori.id}">${categori.name}</option>
                    </#if>
                </#list>
            </select>
        </div>
        <div class="form-row">
            <label>Загрузите фотографию</label>
        </div>
        <div class="form-row mb-2">
            <input id="url_photo" type="file" name="url_photo" multiple>
        </div>
        <div class="form-row mb-2">
            <label>Введите стоимость</label>
            <input id="price" type="text" name="price" class="form-control" placeholder="Введите стоимость"
                   value="<#if productsUpdate?has_content>${productsUpdate.price}</#if>">
        </div>
        <button type="submit">Добавить</button>
    </form>
</#macro>