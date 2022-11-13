<template>
  <div>
    <v-container>
      <h1 class="text-center">Employee List</h1>
      <v-data-table
      :headers="headers"
      :items="employeeList"
      :items-per-page="5"
      >
      <template v-slot:item.actions="{ item }">
        <v-btn
          class="mr-3"
          color="primary"
          fab
          x-small
          dark
          @click="onClickEditBtn(item)"
        >
          <v-icon>mdi-pencil</v-icon>
        </v-btn>

        <v-btn color="red" fab x-small dark @click="onClickDeleteBtn(item)">
          <v-icon>mdi-delete</v-icon>
        </v-btn>
      </template>
      </v-data-table>

      <!-- Update Dialog -->
    <v-dialog v-model="updateDialog" width="500">
      <v-card>
        <v-card-title>Edit Employee</v-card-title>
        <v-card-text>
          <v-form ref="employeeForm" v-model="employeeForm">
            <v-text-field
            label="FirstName"
            v-model="firstName"
            :rules="[(v) => !!v || 'Required']"
            required
            >
            </v-text-field>

            <v-text-field
            label="LastName"
            v-model="lastName"
            :rules="[(v) => !!v || 'Required']"
            required
            >
            </v-text-field>

            <v-text-field
            label="Age"
            v-model="age"
            :rules="[(v) => !!v || 'Required']"
            required
            type="number"
            >
            </v-text-field>

            <v-select
            :items="genderList"
            label="Gender"
            v-model="gender"
            >
            </v-select>

            <v-select
            :items="departmentList"
            label="Department"
            v-model="department"
            >
            </v-select>

            <v-btn color="info" @click="updateEmployee">
                Update Employee
            </v-btn>
          </v-form>
        </v-card-text>
      </v-card>
    </v-dialog>

      <!-- Delete Dialog -->
    <v-dialog v-model="deleteDialog" width="500">
      <v-card>
        <v-card-title>Remove Employee</v-card-title>
        <v-card-text>
          Are You Sure?
          <v-row class="pa-5">
            <v-col cols="4" class="pa-0">ID : </v-col>
            <v-col cols="8" class="pa-0">{{ toDeleteEmployee.id }}</v-col>
            <v-col cols="4" class="pa-0">Name : </v-col>
            <v-col cols="8" class="pa-0"> {{ toDeleteEmployee.firstName }} {{ toDeleteEmployee.lastName }}</v-col>
          </v-row>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn @click="deleteDialog = false">Cancel</v-btn>
          <v-btn color="red" dark @click="deleteEmployee(toDeleteEmployee.id)"
            >Delete</v-btn
          >
        </v-card-actions>
      </v-card>
    </v-dialog>
    </v-container>
  </div>
</template>

<script>
import http from "../utils/http.js"

export default {
    name: "home",

    components: {},

    data() {
      return {
        headers: [
          { text: "ID", value: "id", sortable: true },
          { text: "FirstName", value: "firstName", sortable: true },
          { text: "LastName", value: "lastName", sortable: true },
          { text: "Age", value: "age", sortable: true },
          { text: "Gender", value: "gender", sortable: true },
          { text: "Department", value: "department.departmentRes", sortable: true },
          { text: "Actions", value: "actions", sortable: false },
        ],
        employeeList: [],

        deleteDialog: false,
        toDeleteEmployee: {},

        updateDialog: false,
        employeeForm: false,
        firstName: "",
        lastName: "",
        age: null,
        gender: null,
        department: "",
        departmentId: null,
        updateEmployeeId: null,

        genderList: ['MALE','FEMALE'],
        departmentList: ['Administration','Techinal Support','Design','Coding','Testing'],

      }
    },
    async created() {
      await this.fetchEmployees();
    },
    methods: {
      async fetchEmployees() {
        const resp = await http.get("/api/employees");
        if (resp.status === 200) {
          const data = await resp.json();
          if (data) {
            this.employeeList = data;
            // console.log(data)
          }
        }
      },

      onClickEditBtn(item) {
        this.updateDialog = true;
        this.updateEmployeeId = item.id;
        this.firstName = item.firstName;
        this.lastName = item.lastName;
        this.age = item.age;
        this.gender = item.gender;
       this.department = item.department.departmentRes;
      },
      async updateEmployee() {
        if (this.$refs.employeeForm.validate()) {
            if (this.department == "Administration") {
                this.departmentId = 1
            } else if (this.department == "Techinal Support") {
                this.departmentId = 2
            } else if (this.department == "Design") {
                this.departmentId = 3
            } else if (this.department == "Coding") {
                this.departmentId = 4
            } else if (this.department == "Testing") {
                this.departmentId = 5
            } else {
                console.log("sorry")
            }

            const resp = await http.put("/api/employees", {
                id: this.updateEmployeeId,
                firstName: this.firstName,
                lastName: this.lastName,
                age: this.age,
                gender: this.gender,
                department: {
                    id: this.departmentId
                }
            });
            if (resp.status === 200) {
              await this.fetchEmployees();
              this.updateDialog = false;
              this.firstName = "";
              this.lastName = "";
              this.age = null;
              this.gender = null;
              this.department = "";
            }
        }
      },

      onClickDeleteBtn(item) {
        this.toDeleteEmployee = item;
        this.deleteDialog = true;
      },
      async deleteEmployee(id) {
        const resp = await http.del("/api/employee/" + id);
        if (resp.status === 200) {
          await this.fetchEmployees();
          this.deleteDialog = false;
        }
      }
    },

}
</script>

<style scoped>
</style>