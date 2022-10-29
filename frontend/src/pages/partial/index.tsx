import "./styles.css";
import Chart from "react-apexcharts";

function Partial() {

  const state = {
    options: {
      chart: {
        background: "transparent",
        foreColor: "red"
      },
      colors: ["#a8dadc", "#ed7947", "#00D4FF", "#ffd6a5"],
      legend: {
        show: false
      },
      tooltip: {
        enabled: true
      },
      plotOptions: {
        pie: {
          customScale: 1.0,
          expandOnClick: false,
          dataLabels: {
            offset: 60,
          },
        },
      }
    },
    series: [20, 30, 10, 40],
    labels: ['A', 'B', 'C', 'D']
  }
  return (
    <div className="partial-container">
      <div className="partial-content">
        <div className="card-content">
          <div className="card-base card-graph">
            <h1 className="title">Vencedor</h1>
            <Chart options={state.options} series={state.series} type="donut" width="320" />
          </div>
          <div className="card-base card-vice card-graph">
            <h1 className="title">Vice Campeão</h1>
            <Chart options={state.options} series={state.series} type="donut" width="320" />
          </div>
          <div className="card-base card-graph">
            <h1 className="title">Terceiro Colocado</h1>
            <Chart options={state.options} series={state.series} type="donut" width="320" />
          </div>
        </div>
        <div className="card-base card-table">
          <table className="records-table" cellPadding="0" cellSpacing="0">
            <thead>
              <tr>
                <th>DATA</th>
                <th>NOME</th>
                <th>IDADE</th>
                <th>CAMPEÃO</th>
                <th>VICE CAMPEÃO</th>
                <th>3º LUGAR</th>
              </tr>
            </thead>
            <tbody>
              {/* {recordsResponse?.content.map(record =>( */}
              <tr key="1">
                <td>29/10/2022</td>
                <td>Roberto Barbosa</td>
                <td>37</td>
                <td>Brasil</td>
                <td>Argentina</td>
                <td>Chile</td>
              </tr>
              <tr key="2">
                <td>29/10/2022</td>
                <td>Roberto Barbosa</td>
                <td>37</td>
                <td>Brasil</td>
                <td>Argentina</td>
                <td>Chile</td>
              </tr>
              <tr key="3">
                <td>29/10/2022</td>
                <td>Roberto Barbosa</td>
                <td>37</td>
                <td>Brasil</td>
                <td>Argentina</td>
                <td>Chile</td>
              </tr>
              <tr key="4">
                <td>29/10/2022</td>
                <td>Roberto Barbosa</td>
                <td>37</td>
                <td>Brasil</td>
                <td>Argentina</td>
                <td>Chile</td>
              </tr>
            </tbody>
          </table>
        </div>
        {/* {guestsResponse && guestsResponse.totalPages > 1 && (
        <Pagination
          totalPages={guestsResponse.totalPages}
          activePage={activePage}
          onChange={(page) => handleChangePage(page)}
        />
      )} */}
      </div>
    </div>
  )
}

export default Partial;