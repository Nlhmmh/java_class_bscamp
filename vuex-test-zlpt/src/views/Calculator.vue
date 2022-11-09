<template>
  <div>
    <v-container>
        <h2 class="text-center mt-3 mb-3">Calculator</h2>
        <v-divider></v-divider>
        <v-row class="mt-3">
            <v-col cols="4"></v-col>
            <v-col cols="4">
                <v-card class="text-center px-6 py-3" elevation="6">
                    <h2 style="font-size: 40px;">{{ result }}</h2>
                </v-card>
            </v-col>
            <v-col cols="4"></v-col>
        </v-row>
        <v-row>
            <v-col cols="2"></v-col>
            <v-col cols="3">
                <v-text-field
                v-model="firstNumber"
                label="Enter first number"
                type="number"
                outlined
                dense
                ></v-text-field>
            </v-col>
            <v-col cols="2">
                <v-select
                label="Choose Operator"
                :items="operators"
                v-model="operator"
                dense
                outlined
                ></v-select>
            </v-col>
            <v-col cols="3">
                <v-text-field
                v-model="secondNumber"
                label="Enter second number"
                type="number"
                outlined
                dense
                ></v-text-field>
            </v-col>
            <v-col cols="2"></v-col>
        </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
    name: "calculator",
    data() {
        return {
            firstNumber: null,
            secondNumber: null,
            operator: "",
            operators: ['+','-','x','/'],
            result: 0,
        }
    },
    watch: {
    operator: {
      handler: function (newVal, oldVal) {
        if (newVal) {
            this.showResult();
        }
      },
      deep: true
    },
    firstNumber: {
      handler: function (newVal, oldVal) {
        if (newVal) {
            this.showResult();
        }
      },
      deep: true
    },
    secondNumber: {
      handler: function (newVal, oldVal) {
        if (newVal) {
            this.showResult();
        }
      },
      deep: true
    }
  },
  methods: {
    showResult() {
        if (this.operator == '+') {
            this.result = parseInt(this.firstNumber) + parseInt(this.secondNumber);
        } else if (this.operator == '-') {
            this.result = this.firstNumber - this.secondNumber;
        } else if (this.operator == 'x') {
            this.result = this.firstNumber * this.secondNumber;
        } else if (this.operator == '/') {
            this.result = this.secondNumber / this.firstNumber;
        } else {
            this.result = 0;
        }
    }
  }

}
</script>

<style>

</style>