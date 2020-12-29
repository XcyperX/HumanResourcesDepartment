<#macro login registration user>
    <div class="container pl-5 pr-5">
        <div class="row">
            <div class="col-sm">
                <#if registration>
                <form id="createUser" name="createUser">
                    <div class="form-row">
                        <label>Добавить нового пользователя</label>
                    </div>
                    <#else>
                    <form id="updateUser" name="updateUser">
                        <div class="form-row">
                            <label>Редактировать пользователя</label>
                        </div>
                        </#if>
                        <div class="form-row mb-2">
                            <label>Почта</label>
                            <input id="email" type="text" name="email" class="form-control" placeholder="Введите почту"
                                   value="<#if user?has_content>${user.email}</#if>">
                        </div>
                        <div class="form-row mb-2">
                            <label>Имя</label>
                            <input id="name" type="text" name="name" class="form-control" placeholder="Введите имя"
                                   value="<#if user?has_content>${user.name}</#if>">
                        </div>
                        <div class="form-row mb-2">
                            <label>Пароль</label>
                            <input id="password" type="text" name="password" class="form-control"
                                   placeholder="Введите пароль" value="<#if user?has_content>${user.password}</#if>">
                        </div>
                        <div class="form-row mb-2">
                            <label>Уровень доступа</label>
                            <select id="role" class="form-control mb-3">
                                <#list roles?values as role>
                                    <option value="${role}">${role.getNameRole()}</option>
                                </#list>
                            </select>
                        </div>
                        <#if registration>
                            <div class="form-row">
                                <input class="btn btn-primary  mb-4" type="button" onclick="submitNewUser()"
                                       value="Добавить сотрудника">
                            </div>
                        <#else>
                            <div class="form-row">
                                <input class="btn btn-primary  mb-4" type="button" onclick="submitUpdateUserById(${user.id})"
                                       value="Изменить сотрудника">
                            </div>
                        </#if>
                    </form>
            </div>
        </div>
    </div>
</#macro>

