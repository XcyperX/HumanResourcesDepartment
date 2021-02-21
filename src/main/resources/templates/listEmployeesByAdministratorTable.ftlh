<#import "parts/common.ftlh" as c>
<#import "parts/listEmployees.ftlh" as le>
<#import "parts/listSubdivision.ftlh" as sb>
<#import "parts/listPositionNames.ftlh" as pn>
<#import "parts/createProducts.ftlh" as p>
<#import "parts/listStore.ftlh" as store>
<#import "parts/listManufaturer.ftlh" as man>
<#import "parts/createEmployee.ftlh" as ce>

<@c.page>
    <div class="row">
        <div class="col-sm-2">
            <div class="container">
                <div class="row mb-2">
                    <p class="text-justify">Количество сотрудников: ${countAllUsers}</p>
                </div>
                <div class="row">
                    <button type="button" class="btn btn-primary btn-block mb-2" data-toggle="modal"
                            data-target="#createProduct">
                        Добавить сотрудника
                    </button>
                    <!-- Modal -->
                    <div class="modal fade" id="createProduct" tabindex="-1" role="dialog"
                         aria-labelledby="exampleModalLabel"
                         aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-body">
                                    <@ce.employee employees="" subdivisions=subdivisions positionsNames=positionNames/>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена
                                    </button>
                                    <button type="button" class="btn btn-primary"
                                            onclick="submitCrateAndUpdateEmployees()">Добавить
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <button type="button" class="btn btn-primary btn-block mb-2" data-toggle="modal"
                            data-target="#createStore">
                        Список подразделений
                    </button>
                    <!-- Modal -->
                    <div class="modal fade" id="createStore" tabindex="-1" role="dialog"
                         aria-labelledby="exampleModalLabel"
                         aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Список подразделений</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <@sb.listSubdivision subdivisions=subdivisions/>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <button type="button" class="btn btn-primary btn-block mb-2" data-toggle="modal"
                            data-target="#createManufacturer">
                        Список должностей
                    </button>
                    <!-- Modal -->
                    <div class="modal fade" id="createManufacturer" tabindex="-1" role="dialog"
                         aria-labelledby="exampleModalLabel"
                         aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Список должностей</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <@pn.listPositionNames positionNames=positionNames/>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row mb-2">
                    <label>Выберите роль</label>
                    <select id="subdivision_id" class="form-control">
                        <option value="all">Все</option>
                        <#list roles?values as role>
                            <option value="${role}">${role.getNameRole()}</option>
                        </#list>
                    </select>
                </div>
                <div class="row mb-2">
                    <label>Выберите подразделение</label>
                    <select id="subdivision_id" class="form-control">
                        <option value="all">Все</option>
                        <#list subdivisions as subdivision>
                            <option value="${subdivision.id}">${subdivision.name}</option>
                        </#list>
                    </select>
                </div>
                <div class="row mb-2">
                    <label>Выберите должность</label>
                    <select id="position_id" class="form-control">
                        <option value="all">Все</option>
                        <#list positionNames as positionName>
                            <option value="${positionName.id}">${positionName.name}</option>
                        </#list>
                    </select>
                </div>
                <div class="row mb-2">
                    <label>Выберите дату отпуска</label>
                    <input id="vacationEmployee" type="date" name="vacationEmployee" class="form-control">
                </div>
            </div>
        </div>
        <div class="col-sm-10">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col pl-0">
                        <input id="searchUser" type="text" name="searchUser" class="form-control">
                    </div>
                    <div class="col-auto pr-0">
                        <button type="button" class="btn btn-light">Найти</button>
                    </div>
                </div>
                <div class="row mb-2">
                    <div class="col pl-0">
                        <span>Сортировать: </span>
                        <button type="button" class="btn btn-light btn-sm">По алфавиту</button>
                        <button type="button" class="btn btn-light btn-sm">По дате приема на работу</button>
                    </div>
                </div>
                <div class="row">
                    <@le.listEmployees employees=employees subdivisions=subdivisions positionsNames=positionNames genders=genders/>
                </div>
            </div>
        </div>
    </div>
</@c.page>