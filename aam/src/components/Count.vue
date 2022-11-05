<template>
  <div>
    <h2>{{this.count==8 ? "My Number is 8": "Default" }}</h2>
    <p>Count : {{count}}</p>
    <button class="btn" :disabled="isBtnDisable" @click="countUp()">Count</button>
  </div>
</template>

<script>
export default {
    name:"MyCount",
    components: {
        
    },

    data(){
        return {
            count: 0,
            isBtnDisable: false,
        };
    },

    methods: {
        countUp(){
            this.count++;
            console.log(this.count);
            return this.count;
        },
    }
}
</script>


<style>
.btn {
    padding-top: 30px;
    color: red;
    text-decoration: underline;
    background-color: blueviolet;
}

.btn:hover {
    text-decoration: solid;
    background-color: black;
}
</style>