export interface Customers {
  id?: string;
  name: string;
  address: string;
  city: string;
  phone: number;
}

export interface CustomerTarjetas extends Customers {
  tarjetas: number;
}
