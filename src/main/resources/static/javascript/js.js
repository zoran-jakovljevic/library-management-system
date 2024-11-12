document.addEventListener("DOMContentLoaded", function () {
    const checkoutButtons = document.querySelectorAll(".checkoutBtn");
    const deleteButtons = document.querySelectorAll(".deleteBTN");
    const editButtons = document.querySelectorAll(".editBTN");
    const returnButtons = document.querySelectorAll(".returnBTN");
    const addNewBookForm = document.querySelector("#addNewBookForm");
    const addMemberForm = document.querySelector("#addMemberForm");
    const editMemberForm = document.querySelector("#editMemberForm");

    if(returnButtons){
        returnButtons.forEach(button => {
            button.addEventListener("click", function(){
                const id = button.getAttribute("data-id");

                if (confirm(`Are you sure?`)) {
                    fetch(`/api/${id}`, {
                        method: 'DELETE'
                    })
                    .then(response => {
                        if (response.ok) {
                            alert('Successfully!');
                            location.reload();
                        } else {
                            alert('Failed');
                        }
                    })
                    .catch(error => console.error('Error:', error));
                }

            })
        })
    }

    if(editButtons){
        editButtons.forEach(button => {
            button.addEventListener("click", function(){
                const jmbg = button.getAttribute("data-jmbg");
                const name = button.getAttribute("data-name");
                const address = button.getAttribute("data-address");
                const phone_number = button.getAttribute("data-phone_number");
                const entry_date = button.getAttribute("data-entry_date");
                const expiry_date = button.getAttribute("data-expiry_date");


                const editMemberJmbg = document.getElementById("editMemberJmbg");
                const editMemberAddress = document.getElementById("editMemberAddress");
                const editMemberName = document.getElementById("editMemberName");
                const editMemberPhoneNumber = document.getElementById("editMemberPhoneNumber");
                const editMemberEntryDate = document.getElementById("editMemberEntryDate");
                const editMemberExpiryDate = document.getElementById("editMemberExpiryDate");

                editMemberJmbg.value = jmbg;
                editMemberAddress.value = address;
                editMemberName.value = name;
                editMemberPhoneNumber.value = phone_number;
                editMemberEntryDate.value = entry_date;
                editMemberExpiryDate.value = expiry_date;

                const editMemberModal = new bootstrap.Modal(document.getElementById("editMemberModal"));
                editMemberModal.show();

            })
        })
    }

    if (checkoutButtons) {
        checkoutButtons.forEach(button => {
            button.addEventListener("click", function () {
                const isbn = button.getAttribute("data-isbn");
                const isbnInput = document.getElementById("isbn");

                isbnInput.value = isbn;

                const checkoutModal = new bootstrap.Modal(document.getElementById("checkoutModal"));
                checkoutModal.show();
            });
        });
    }

    if(editMemberForm){
        editMemberForm.addEventListener("submit", function(event){
            event.preventDefault();

            const jmbg = document.getElementById("editMemberJmbg").value;
            const name = document.getElementById("editMemberName").value;
            const address = document.getElementById("editMemberAddress").value;
            const phone_number = document.getElementById("editMemberPhoneNumber").value;
            const entry_date = document.getElementById("editMemberEntryDate").value;
            const expiry_date = document.getElementById("editMemberExpiryDate").value;

            fetch(`/api/members/${jmbg}`, {
                method: "PUT",
                headers: {
                    "Content-Type":"application/json",
                },
                body: JSON.stringify({name, address, phone_number, entry_date, expiry_date}),
            })
            .then(response => {
                if (response.ok) {
                    alert("Successfully edited member");
                    const editmemberInstance = bootstrap.Modal.getInstance(document.getElementById("editMemberModal"));
                    if (editmemberInstance) editmemberInstance.hide();
                    location.reload();
                } else {
                    alert("Error editing member");
                }
            })
            .catch(error => console.error("Error:", error));

        })
    }

if(addMemberForm){
    addMemberForm.addEventListener("submit", function(event){
        event.preventDefault();

        const jmbg = document.getElementById("memberJmbg").value;
        const name = document.getElementById("memberName").value;
        const address = document.getElementById("memberAddress").value;
        const phone_number = document.getElementById("memberPhoneNumber").value;
        const entry_date = document.getElementById("memberEntryDate").value;
        const expiry_date = document.getElementById("memberExpiryDate").value;

        fetch('/api/members/addnewmember', {
            method: "POST",
            headers: {
                "Content-Type":"application/json",
            },
            body: JSON.stringify({jmbg, name, address, phone_number, entry_date, expiry_date}),
        })
        .then(response => {
            if (response.ok) {
                alert("Successfully added new member");
                const addnewmemberInstance = bootstrap.Modal.getInstance(document.getElementById("addMemberModal"));
                if (addnewmemberInstance) addnewmemberInstance.hide();
                location.reload();
            } else {
                alert("Error adding new member");
            }
        })
        .catch(error => console.error("Error:", error));
    });
}


if (addNewBookForm) {
    addNewBookForm.addEventListener("submit", function (event) {
        event.preventDefault();

        const isbn = document.getElementById("isbnBook").value;
        const name = document.getElementById("bookName").value;
        const author = document.getElementById("authorName").value;

        console.log(isbnBook, bookName, authorName)

        fetch('/api/addnewbook', {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ isbn, name, author }),
        })
            .then(response => {
                if (response.ok) {
                    alert("Successfully added the book");
                    const addnewbookInstance = bootstrap.Modal.getInstance(document.getElementById("addNewBook"));
                    if (addnewbookInstance) addnewbookInstance.hide();
                    location.reload();
                } else {
                    console.log(response)
                    alert("Error adding the book");
                }
            })
            .catch(error => console.error("Error:", error));
    });
}

if (deleteButtons) {
        console.log(deleteButtons)
        deleteButtons.forEach(button => {
                button.addEventListener('click', function () {
                    const jmbg = button.getAttribute('data-jmbg');

                    if (confirm(`Are you sure you want to delete member with JMBG: ${jmbg}?`)) {
                        fetch(`/api/members/${jmbg}`, {
                            method: 'DELETE'
                        })
                        .then(response => {
                            if (response.ok) {
                                alert('Member deleted successfully!');
                                location.reload();
                            } else {
                                alert('Failed to delete member. Member not found.');
                            }
                        })
                        .catch(error => console.error('Error:', error));
                    }
                });
            });

    }


    const checkoutForm = document.getElementById("checkoutForm");
    if (checkoutForm) {
        checkoutForm.addEventListener("submit", function (event) {
            event.preventDefault();

            const isbn = document.getElementById("isbn").value;
            const jmbg = document.getElementById("jmbg").value;

            fetch(`/api/checkout?memberJmbg=${jmbg}&bookIsbn=${isbn}`, {
                method: "POST",
            })
            .then(response => {
                if (response.ok) {
                    alert("Successfully checked-out");
                    const checkoutModalInstance = bootstrap.Modal.getInstance(document.getElementById("checkoutModal"));
                    if (checkoutModalInstance) checkoutModalInstance.hide();
                    location.reload();
                } else {
                    alert("Error during check-out");
                }
            })
            .catch(error => console.error("Error:", error));
        });
    }
});
