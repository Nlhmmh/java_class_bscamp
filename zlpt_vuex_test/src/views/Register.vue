<template>
  <div>
    <v-container>
        <h2 class="text-center mt-3">Student Register Form</h2>
        <v-row class="mt-3">
            <v-col cols="4"></v-col>
            <v-col cols="4">
                <v-form ref="registerForm" v-model="registerForm">
                    <v-text-field
                    label="Full Name"
                    placeholder="Enter your Name"
                    v-model="name"
                    :rules="[(v) => !!v || 'Required']"
                    required
                    ></v-text-field>

                    <v-text-field
                    label="Email"
                    placeholder="test@example.com"
                    v-model="email"
                    type="email"
                    :rules="[(v) => !!v || 'Required',(v) => /.+@.+\..+/.test(v) || 'E-mail must be valid']"
                    required
                    ></v-text-field>

                    <v-text-field
                    label="Phone"
                    placeholder="09xxxxxxxxx"
                    v-model="phone"
                    :rules="[(v) => !!v || 'Required']"
                    required
                    type="number"
                    ></v-text-field>

                    <v-select
                    v-model="gender"
                    :items="items"
                    label="Gender"
                    :rules="[(v) => !!v || 'Required']"
                    required
                    >
                    </v-select>

                    <v-select
                    v-model="year"
                    :items="years"
                    label=" What year are you in"
                    :rules="[(v) => !!v || 'Required']"
                    required
                    >
                    </v-select>

                    <v-select
                    v-model="major"
                    :items="majors"
                    label=" Choose Your major"
                    :rules="[(v) => !!v || 'Required']"
                    required
                    >
                    </v-select>

                    <v-row>
                        <v-col class="text-end">
                            <v-btn color="info" @click="register" :disabled="!registerForm">Register</v-btn>
                        </v-col>
                    </v-row>
                </v-form>
            </v-col>
            <v-col cols="4"></v-col>
        </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
    name: "register",
    data() {
        return {
            registerForm: false,
            items: ['unknown', 'male', 'female'],
            years: ['First Year','Second Year','Third Year','Forth Year'],
            majors: ['Computer Science', 'Sociology', 'Biochemistry', 'Law', 'Business'],
            name: "",
            email: "",
            phone: "",
            gender: "",
            year: "",
            major: "",
        }
    },
    methods: {
        register() {
            if (this.$refs.registerForm.validate()) {
                this.$store.commit("setIsRegister", true);
                this.$store.commit("setStudentInfo", {
                name: this.name,
                email: this.email,
                phone: this.phone,
                gender: this.gender,
                year: this.year,
                major: this.major,
                });
                this.$router.push({ path: "/" });
            }
        }
    }

}
</script>

<style>

</style>