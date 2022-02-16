const url = 'http://localhost:8080/api/v1/user/'

allUser()
currentUser()
Roles()

function allUser() {
    fetch(url)
        .then(resp => resp.json())
        .then(res => {
            for (let user of res) {
                let table =
                    `<tr>
                        <td>${user.id}</td>
                        <td>${user.firstname}</td>
                        <td>${user.lastname}</td>
                        <td>${user.age}</td>
                        <td>${user.username}</td>
                        <td>${mapRoles(user)}</td>
                        <td>
                            <button class="btn btn-info"
                                    onclick="userEditModal(${user.id})"
                                    type="button"
                                    data-toggle="modal"
                                    data-target="#modalEdit"
                                    id="table_button_edit_${user.id}">
                            Edit
                           </button>
                        </td>
                        <td>
                            <button class="btn btn-danger"
                                    onclick="userDeleteModal(${user.id})"
                                    type="button"
                                    data-toggle="modal"
                                    data-target="#modalDelete"
                                    id="table_button_delete">
                            Delete
                           </button>
                        </td>
                    </tr>`
                $('#userTable').append(table)
            }
        })


    try {
        document.getElementById('new_user_button').addEventListener(
            'click', addNewUser, false
        );
    } catch (e) {
    }
}

function currentUser() {
    fetch(url + 'me')
        .then(resp => resp.json())
        .then(user => {
            $('#current_user_username').append(user.username)
            $('#current_user_role').append(mapRoles(user))

            let table = `
                <tr>
                        <td>${user.id}</td>
                        <td>${user.firstname}</td>
                        <td>${user.lastname}</td>
                        <td>${user.age}</td>
                        <td>${user.username}</td>
                        <td>${mapRoles(user)}</td>
                </tr>
            `
            $('#current_user_tbody').append(table)
            $('#user_current_user_tbody').append(table)
        })
}

function addNewUser(e) {
    fetch(url, {
        method: 'POST',
        body: JSON.stringify({
            firstname: $('#firstname_new').val(),
            lastname: $('#lastname_new').val(),
            age: $('#age_new').val(),
            username: $('#username_new').val(),
            password: $('#password_new').val(),
            roles: $('#roles_new').val(),
        }),
        headers: {'Content-Type': 'application/json'}
    })

    e.preventDefault()
    $('.nav-tabs a[href="#users-table"]').tab('show');
    setTimeout(updateTable, 100)
    document.getElementById('new-user-form').reset();
}

function userEditModal(userId) {
    fetch(url + userId)
        .then(resp => resp.json())
        .then(user => {
            $('#id_edit').attr('value', user.id)
            $('#firstname_edit').attr('value', user.firstname)
            $('#lastname_edit').attr('value', user.lastname)
            $('#age_edit').attr('value', user.age)
            $('#username_edit').attr('value', user.username)
            document.getElementById('button_edit').addEventListener(
                'click', editUser, false
            );
        })

}

function editUser(e) {
    fetch(url, {
        method: 'POST',
        body: JSON.stringify({
            id: $('#id_edit').val(),
            firstname: $('#firstname_edit').val(),
            lastname: $('#lastname_edit').val(),
            age: $('#age_edit').val(),
            username: $('#username_edit').val(),
            password: $('#password_edit').val(),
            roles: $('#roles_edit').val(),
        }),
        headers: {'Content-Type': 'application/json'}
    })

    e.preventDefault()
    $('#modalEdit').modal('hide')
    setTimeout(updateTable, 100)
}


function userDeleteModal(userId) {
    fetch(url + userId)
        .then(resp => resp.json())
        .then(user => {
            $('#id_delete').attr('value', user.id)
            $('#firstname_delete').attr('value', user.firstname)
            $('#lastname_delete').attr('value', user.lastname)
            $('#age_delete').attr('value', user.age)
            $('#username_delete').attr('value', user.username)
            document.getElementById('button_delete').addEventListener(
                'click', deleteUser, false
            );
        })
}

function deleteUser(e) {
    fetch(url + $('#id_delete').val(), {method: 'DELETE'})

    e.preventDefault()
    $('#modalDelete').modal('hide')
    setTimeout(updateTable, 100)
}

function Roles() {
    fetch(url + 'roles')
        .then(resp => resp.json())
        .then(roles => {
            for (let role of roles) {
                let t = `<option value=${role.role}> ${role.role} </option>`
                $('#roles_edit').append(t)
                $('#roles_new').append(t)
            }
        })
}


function mapRoles(user) {
    return user.roles.map(i => i.role).join(', ')
}

function updateTable() {
    $('#userTable').empty()
    allUser()
}