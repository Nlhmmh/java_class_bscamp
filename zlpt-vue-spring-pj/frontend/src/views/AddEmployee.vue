<template>
  <div>
    <v-container>
        <h2 class="text-center">Add Employee</h2>
        <v-form ref="employeeForm" v-model="employeeForm">
            <v-row>
                <v-col cols="4"></v-col>
                <v-col cols="4">
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

                    <v-btn color="primary" @click="addEmployee">
                        Add Employee
                    </v-btn>
                </v-col>
                <v-col cols="4"></v-col>
            </v-row>
        </v-form>
    </v-container>
  </div>
</template>

<script>
import http from '@/utils/http'
export default {
    name: "add-employee",
    data() {
        return {
            employeeForm: false,
            firstName: "",
            lastName: "",
            age: null,
            gender: null,
            department: "",
            departmentId: null,

            genderList: ['MALE','FEMALE'],
            departmentList: ['Administration','Techinal Support','Design','Coding','Testing'],
        }
    },
    methods: {
        async addEmployee() {
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

                const resp = await http.post("/api/employees", {
                    firstName: this.firstName,
                    lastName: this.lastName,
                    age: this.age,
                    gender: this.gender,
                    department: {
                        id: this.departmentId
                    }
                });
                if (resp.status === 200) {
                    this.$router.push({ path: '/' });
                }

            }
        }
    }
}
</script>

<style>

</style>