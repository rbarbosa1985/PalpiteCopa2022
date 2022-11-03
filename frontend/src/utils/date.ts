import moment from 'moment';

export const formatDate = (date: string) => {
    console.log(date);
    return moment(date).format('DD/MM/YY, HH:mm');
    // return moment(date).format('DD/MM/YY HH:mm');
}