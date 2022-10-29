import "./styles.css";
import { toast } from "react-toastify";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import Logo from "../../assets/images/logo.png";

type FormState = {
  name: string;
  email: string;
  age: number;
  winner: string;
  vice: string;
  third: string;
}

function Guess() {

  const { register, handleSubmit, formState: { errors } } = useForm<FormState>();
  const navigate = useNavigate();


  const handleCancel = () => {
    navigate("/");
  }

  const onSubmit = (/*data: FormState*/) => {

  }

  return (
    <div className="container">
      <form onSubmit={handleSubmit(onSubmit)} className="form card-base">
        <div>
          <h1 className="h1-text">Palpite</h1>
        </div>
        <div className="margin-bottom-30">
          <p className="form-names">Nome:</p>
          <input
            type="text"
            {...register("name", { required: "Campo Obrigatório" })}
            placeholder="Seu Nome"
            className="form-control  input-base"
          />
          {errors.name && (
            <div className="invalid-feedback d-block">
              {errors.name.message}
            </div>
          )}
        </div>

        <div className="margin-bottom-30">
          <p className="form-names">Idade:</p>
          <input
            type="number"
            {...register("age", { required: "Campo Obrigatório", valueAsNumber: true })}
            placeholder="Sua Idade"
            className="form-control  input-base"
          />
          {errors.age && (
            <div className="invalid-feedback d-block">
              {errors.age.message}
            </div>
          )}
        </div>

        <div className="margin-bottom-30">
          <p className="form-names">Email:</p>
          <input
            type="text"
            {...register("email", { required: "Campo Obrigatório", pattern: { value: /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/, message: "Email invalido!" } })

            }
            placeholder="Seu Nome"
            className="form-control  input-base"
          />
          {errors.email && (
            <div className="invalid-feedback d-block">
              {errors.email.message}
            </div>
          )}
        </div>

        <div className="margin-bottom-30">
          <p className="form-names">Campeão:</p>
          <select {...register("winner", { required: "Campo Obrigatório" })} className="form-control  input-base">
            <option value="Brasil">Brasil</option>
            <option value="Argentina">Argentina</option>
            <option value="Chile">Chile</option>
          </select>
          {errors.winner && (
            <div className="invalid-feedback d-block">
              {errors.winner.message}
            </div>
          )}
        </div>

        <div className="margin-bottom-30">
          <p className="form-names">Vice Campeão:</p>
          <select {...register("vice", { required: "Campo Obrigatório" })} className="form-control  input-base">
            <option value="Brasil">Brasil</option>
            <option value="Argentina">Argentina</option>
            <option value="Chile">Chile</option>
          </select>
          {errors.vice && (
            <div className="invalid-feedback d-block">
              {errors.vice.message}
            </div>
          )}
        </div>

        <div className="margin-bottom-30">
          <p className="form-names">Terceiro Lugar:</p>
          <select {...register("third", { required: "Campo Obrigatório" })} className="form-control  input-base">
            <option value="Brasil">Brasil</option>
            <option value="Argentina">Argentina</option>
            <option value="Chile">Chile</option>
          </select>
          {errors.third && (
            <div className="invalid-feedback d-block">
              {errors.third.message}
            </div>
          )}
        </div>

        <div className="base-form-action">
          <button className="btn btn-success border-radius-10 btn-lg form-salvar">
            SALVAR
          </button>
          <button type="button" className="btn btn-danger border-radius-10 btn-lg form-cancelar" onClick={handleCancel}>
            CANCELAR
          </button>
        </div>
      </form>
    </div>
  )
}

export default Guess;