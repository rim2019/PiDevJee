using Domain.entities;
using MyFinance.Data.Infrastructure;
using Service.Pattern;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service
{
    public class OffreService : Service<Offre>, IOffreService
    {
        static IDataBaseFactory Factory = new DataBaseFactory();
        static IUnitOfWork UTK = new UnitOfWork(Factory);
        public OffreService() : base(UTK)
        {

        }
        
    }
}
