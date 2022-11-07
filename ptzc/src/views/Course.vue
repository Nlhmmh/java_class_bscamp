<template>
  <div>
    <v-form ref="courseForm">
        <!-- ID Textfield -->
        <v-text-field 
            v-model="id"
            label="ID"
            placeholder="10"
            :rule="[(v) => !!v || 'Required']"
            required
        ></v-text-field>
        <!-- Subject Textfield -->
        <v-text-field 
            v-model="subject"
            label="Subject"
            placeholder="English"
            :rule="[(v) => !!v || 'Required']"
            required
        ></v-text-field>
        <!-- Description Textarea -->
        <v-textarea
            v-model="description"
            label="Description"
            clearable
            counter
        ></v-textarea>
        <v-btn class="mt-5" color="success" @click="onClickSave">Save</v-btn>
    </v-form>
  </div>
</template>

<script>
export default {
    name:"course",
    data(){
        return {
            id:"",
            subject:"",
            description:"",
        };
    },
    methods:{
        onClickSave(){
            if(this.$refs.courseForm.validate()){
                // Store in vuex state <=> mutation
                this.$store.commit("setIsCourse",true);
                this.$store.commit("setCourseInfo",{
                    id:this.id,
                    subject:this.subject,
                    description:this.description,
                });

                // Go to screen
                this.$router.push({path:"/courseview"});
            }else{
                console.log("Validate Failed!");
            }
        },
    },
}
</script>

<style>

</style>