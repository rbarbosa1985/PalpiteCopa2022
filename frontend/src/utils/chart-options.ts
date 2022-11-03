export const pieOptions = {
  chart: {
    background: "transparent",
    foreColor: "red",
  },
  colors: ["#daa520", "#c0c0c0", "#cd7f32"],
  legend: {
    show: true,
  },
  tooltip: {
    enabled: true,
  },
  dataLabels: {
    enabled: false,
    // offsetX: 100,
    // offsetY: 100,
    // style: {
    //   colors: ["#daa520", "#c0c0c0", "#cd7f32"],
    //   fontSize: "20px",
    //   fontWeight: 700,
    //   fontFamily: "Qatar2022Arabic-Bold"
    // },
  },
  plotOptions: {
    pie: {
      customScale: 0.8,
      expandOnClick: false,
      dataLabels: {
        offset: 60,
      }
    },
  },
};