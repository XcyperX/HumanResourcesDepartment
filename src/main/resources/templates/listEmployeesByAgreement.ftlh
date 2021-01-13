<#import "parts/common.ftlh" as c>
<#import "parts/listEmployees.ftlh" as e>
<#import "parts/createAgreement.ftlh" as a>

<@c.page>
    <a class="btn btn-primary mb-2" type="button" href="/pdf/request/agreement">Сформировать отчет</a>
    <button type="button" class="btn btn-primary mb-2" data-toggle="modal" data-target="#createAgreement">
        Создать договор
    </button>
    <!-- Modal -->
    <div class="modal fade" id="createAgreement" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Форма создания договора</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <@a.agreement employees=employees/>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена</button>
                    <button type="button" class="btn btn-primary" onclick="submitCreateAgreement()">Создать договор</button>
                </div>
            </div>
        </div>
    </div>
    <@e.listEmployees agreementData=agreementData employees=employees subdivisions=subdivisions positions=positions positionsNames=positionsNames agreement=true/>
</@c.page>