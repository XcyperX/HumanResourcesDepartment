<#macro pruduct products categories manufacturer stores user create=false>
    <div class="form-row mb-2">
        <label>Введите название</label>
        <input id="name" type="text" name="name" class="form-control" placeholder="Введите название"
               value="<#if products?has_content>${products.name}</#if>">
    </div>
    <div class="form-row mb-2">
        <label>Введите описание</label>
        <textarea id="description" name="description" class="form-control" maxlength="230"
                  placeholder="Введите краткое описание"><#if products?has_content>${products.description}</#if></textarea>
    </div>
    <div class="form-row mb-2">
        <div class="col pl-0 ml-0">
            <label>Выберите категорию</label>
            <select id="categories_id" class="form-control">
                <#list categories as categori>
                    <#if products?has_content>
                        <#if categori.id == products.categoriesId>
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
        <div class="col">
            <label>Выберите производителя</label>
            <select id="manufacturer_id" class="form-control">
                <#list manufacturer as manufacter>
                    <#if products?has_content>
                        <#if manufacter.id == products.manufacturerId>
                            <option value="${manufacter.id}" selected>${manufacter.name}</option>
                        <#else>
                            <option value="${manufacter.id}">${manufacter.name}</option>
                        </#if>
                    <#else>
                        <option value="${manufacter.id}">${manufacter.name}</option>
                    </#if>
                </#list>
            </select>
        </div>
        <div class="col pr-0 mr-0">
            <label>Выберите склад</label>
            <select id="store_id" class="form-control">
                <#list stores as store>
                    <#if products?has_content>
                        <#if store.id == products.storeId>
                            <option value="${store.id}" selected>${store.name}</option>
                        <#else>
                            <option value="${store.id}">${store.name}</option>
                        </#if>
                    <#else>
                        <option value="${store.id}">${store.name}</option>
                    </#if>
                </#list>
            </select>
        </div>
    </div>
    <div class="form-row">
        <label>Загрузите фотографию</label>
    </div>
    <div class="form-row mb-2">
        <input id="url_photo" type="file" name="url_photo"
               value="<#if products?has_content>${products.urlPhoto}</#if>">
    </div>
    <input id="user_id" type="text" name="user_id" class="form-control"
           value="<#if user?has_content>${user.id}</#if>" hidden>
    <div class="form-row mb-2">
        <div class="col pl-0 ml-0">
            <label>Количество товара</label>
            <input id="amount" type="text" name="amount" class="form-control" placeholder="Введите количество товара"
                   value="<#if products?has_content>${products.amount}</#if>">
        </div>
        <div class="col pr-0 mr-0">
            <label>Введите стоимость</label>
            <input id="price" type="text" name="price" class="form-control" placeholder="Введите стоимость"
                   value="<#if products?has_content>${products.price}</#if>">
        </div>
    </div>
</#macro>