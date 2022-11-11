<template>
  <div>
    <h1>Student Registration Form</h1>
    <v-form ref="registerForm">
      <v-text-field
        v-model="name"
        label="Name"
        placeholder="Enter your name"
        required
        :rules="[(v) => !!v || 'Required']"
      >
      </v-text-field>
      <v-text-field
        v-model="email"
        label="Email"
        placeholder="eg.test@gmail.com"
        required
        :rules="[(v) => !!v || 'Required']"
      >
      </v-text-field>
      <v-text-field
        v-model="age"
        label="Age"
        placeholder="Enter your age"
        required
        type="number"
        :rules="[
          (v) => !!v || 'Required',
          (v) => (v && v > 0) || 'Age must be greater than 0',
          (v) => (v && v <= 100) || 'Age must be less than 100',
        ]"
      >
      </v-text-field>

      <label for="gender">Gender</label>
      <v-radio-group v-model="gender" row required>
        <v-radio label="Unknown" value="Unknown"></v-radio>
        <v-radio label="Male" value="Male"></v-radio>
        <v-radio label="Female" value="Female"></v-radio>
      </v-radio-group>
      <v-select
        v-model="language"
        :items="['English', 'Japanese', 'Korean']"
        label="Language"
        required
        placeholder="Select language..."
        :rules="[(v) => !!v || 'Required']"
      >
      </v-select>
      <v-textarea
        v-model="selfIntro"
        label="Self Introduction"
        clearable
        counter
      >
      </v-textarea>
      <v-btn @click="onRegister" color="success"> Register </v-btn>
    </v-form>
  </div>
</template>
<script>
export default {
  name: "register",

  data() {
    return {
      name: "",
      email: "",
      age: 16,
      gender: "Unknown",
      language: "",
      selfIntro: "",
    };
  },

  methods: {
    onRegister() {
      if (this.$refs.registerForm.validate()) {
        this.$store.commit("setIsRegister", true);
        this.$store.commit("setUserInfo", {
          name: this.name,
          email: this.email,
          age: this.age,
          gender: this.gender,
          language: this.language,
          selfIntro: this.selfIntro,
        });
        this.$router.push({ path: "/" });
      } else {
        console.log("Register failed");
      }
    },
  },
};
</script>
<style></style>
